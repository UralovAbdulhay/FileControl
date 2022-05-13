package uz.tatu.filecontrol.service.basic;

import java.util.List;

public interface BaseService<E, I> {

    List<E> findAll();

    E findById(I id);

    void deleteById(I id);

    E save(E entity);


}
