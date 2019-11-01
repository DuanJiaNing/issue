package com.duan.issue;

import com.github.pagehelper.Page;
import org.modelmapper.ModelMapper;

import java.util.List;

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


    public static <Entity, DTO> Page<DTO> page(List<Entity> pageList, Class<DTO> clasz) {
        Page<Entity> epage = (Page) pageList;
        Page<DTO> dpage = new Page<>();
        for (Entity e : epage) {
            DTO dto = DataConverter.map(e, clasz);
            dpage.add(dto);
        }

        dpage.setPageNum(epage.getPageNum());
        dpage.setPageSize(epage.getPageSize());
        dpage.setTotal(epage.getTotal());
        dpage.setPages(epage.getPages());

        /*
        dpage.setOrderBy(epage.getOrderBy());
        if (dpage.size() == 0) {
            dpage.setStartRow(0);
            dpage.setEndRow(0);
        } else {
            dpage.setStartRow(epage.getStartRow() + 1);
            dpage.setEndRow(dpage.getStartRow() - 1 + dpage.size());
        }*/

        return dpage;
    }
}
