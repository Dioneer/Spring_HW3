package Pegas.mapper;

public interface Mapper<F,T> {
    T fromTo(F i);
}
