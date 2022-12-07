package top.it6666.template;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

import java.util.List;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/12/1 23:02
 * @description 保存或更改数据模板
 **/
public interface SaveUpdateDBTemplate<T> {

    default void saveUpdate(List<T> element) {
        if (CollUtil.isEmpty(element)) {
            return;
        }
        // 可加入【多线程】进行再次优化

        // 将 List 平均分，然后在去进行入库
        ListUtil.splitAvg(element, 20).forEach(ele -> {
            int rows = this.batchUpdate(ele);

            // 数据库都不存在的情况
            // 根据上面的代码，目前没有发现bug，但是可以进一步优化，比如：在if (rows < 1)中可以加入多线程，提高入库的效率。
            if (rows < 1) {
                this.batchInsert(ele);
                return;
            }

            // 数据库存在数据的情况，但是有一部分是没有的，那么没有的部分是需要新增进去，但是有的就进行更改
            if (rows != ele.size()) {
                ele.forEach(actionEle -> {
                    List<T> ts = CollUtil.newArrayList(actionEle);
                    if (this.batchUpdate(ts) < 1) {
                        this.batchInsert(ts);
                    }
                });
            }
        });
    }

    int batchUpdate(List<T> elements);

    int batchInsert(List<T> elements);
}
