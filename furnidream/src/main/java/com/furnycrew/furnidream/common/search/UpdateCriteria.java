package com.furnycrew.furnidream.common.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCriteria {
    private String name; // 컬럼명
    private long id;
    private Object value; // 검색값
    private Object start;
    private Object end;
}