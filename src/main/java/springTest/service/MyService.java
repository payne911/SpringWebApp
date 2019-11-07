package springTest.service;

import springTest.dao.MyDao;


public interface MyService<T> {
    MyDao<T> getMainDao();
}
