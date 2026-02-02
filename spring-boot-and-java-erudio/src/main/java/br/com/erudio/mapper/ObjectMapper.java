package br.com.erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectMapper {

    //Esse método irá mapear entidade para dto e vice versa,
    //Será implementado um método genérico para mapear o objeto de origem para o objeto de destino.
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin,destination);
    }

    public static <O,D>List<D> parseListObjects(List<O> origin, Class<D> destination) {

        List<D> destinationObjects = new ArrayList<D>();
        for (Object o : origin){
            destinationObjects.add(mapper.map(o,destination));
        }

        return destinationObjects;
    }



}
