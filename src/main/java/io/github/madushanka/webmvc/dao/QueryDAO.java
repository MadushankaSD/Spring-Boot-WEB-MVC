package io.github.madushanka.webmvc.dao;


import io.github.madushanka.webmvc.entity.CustomEntity;

import java.util.List;

public interface QueryDAO {

    List<CustomEntity> getOrderInfo();

}
