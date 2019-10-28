package com.duan.issue;

import com.github.pagehelper.PageHelper;
import org.modelmapper.ModelMapper;

/**
 * Created on 2019/10/25.
 *
 * @author DuanJiaNing
 */
public class DataConverter {
    private static ModelMapper mapper = new ModelMapper();

    public static <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationType);
    }
}
