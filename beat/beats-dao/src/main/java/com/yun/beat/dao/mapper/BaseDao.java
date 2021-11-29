package com.yun.beat.dao.mapper;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author lmy
 * @date 2021/7/2 17:22
 */

public interface BaseDao<T, I extends Serializable>
        extends PagingAndSortingRepository<T, I>, JpaSpecificationExecutor<T> {
}
