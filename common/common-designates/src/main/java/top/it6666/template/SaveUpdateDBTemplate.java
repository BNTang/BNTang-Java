package top.it6666.template;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 保存更新dbtemplate
 *
 * @author BNTang
 * @date 2022/12/07
 * 目前这个模板对数据库的负载不大，然后呢就是三个条件分支，分支较多，可以改进的点可以使用多线程，但是呢，使用了多线程
 * 就会面临使用多线程带来的一些列线程等方面的问题
 */
public interface SaveUpdateDBTemplate<T> {
    /**
     * 保存更新
     *
     * @param elements 元素
     */
    default void saveUpdate(List<T> elements) {
        if (CollUtil.isEmpty(elements)) {
            return;
        }

        // 主要是把 forEach 替换成了普通的 for 循环，这样可以避免使用 break 或 return 来退出循环。同时，
        // 我们把 ListUtil.splitAvg() 方法的结果直接循环遍历，避免了额外的 lambda 表达式
        // 将 List 平均分，然后在去进行入库
        final int avg = 20;
        for (List<T> element : ListUtil.splitAvg(elements, avg)) {
            int rows = this.batchUpdate(element);

            // 数据库都不存在的情况
            if (rows < 1) {
                this.batchInsert(element);
                break;
            }

            // 数据库存在数据的情况，但是有一部分是没有的，那么没有的部分是需要新增进去，但是有的就进行更改
            List<T> insertElement = new ArrayList<>();
            if (rows != element.size()) {
                for (T e : element) {
                    if (this.batchUpdate(CollUtil.newArrayList(e)) < 1) {
                        insertElement.add(e);
                    }
                }
            }
            if (CollUtil.isNotEmpty(insertElement)) {
                this.batchInsert(insertElement);
            }
        }
    }

    /**
     * 批量更新
     *
     * @param elements 元素
     * @return int
     */
    int batchUpdate(List<T> elements);

    /**
     * 批量插入
     *
     * @param elements 元素
     * @return int
     */
    int batchInsert(List<T> elements);
}
