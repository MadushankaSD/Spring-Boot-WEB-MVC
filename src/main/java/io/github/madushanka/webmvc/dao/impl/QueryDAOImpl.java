package io.github.madushanka.webmvc.dao.impl;



import io.github.madushanka.webmvc.dao.QueryDAO;
import io.github.madushanka.webmvc.entity.CustomEntity;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomEntity> getOrderInfo()  {
        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery("SELECT o.id as orderId, c.customerId as customerId, c.name as customerName, o.date as orderDate, SUM(od.qty * od.unitPrice) AS orderTotal  FROM Customer c INNER JOIN `order` o ON c.customerId=o.customerID INNER JOIN OrderDetail od on o.id = od.Order_id GROUP BY o.id");

        Query<CustomEntity> query = nativeQuery.setResultTransformer(Transformers.aliasToBean(CustomEntity.class));
        List<CustomEntity> list = query.list();
        System.out.println(list.toString());
        return list;

}

}
