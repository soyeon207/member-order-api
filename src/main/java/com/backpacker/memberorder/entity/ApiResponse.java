package com.backpacker.memberorder.entity;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class ApiResponse<T> {

    protected int status = HttpStatus.OK.value();
    protected boolean hasMore;
    protected long offset;
    protected long size;
    protected long totalSize;
    protected List<T> data;

}
