package com.notemaster.api.util;

import com.notemaster.api.entities.Note;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PageWrapper<T> {

    private long totalElements;
    private int pageSize;
    private int currentPage;
    private List<T> data;

    public static <T> PageWrapper<T> wrap  (Page<T> page) {
        PageWrapper<T> wrapPage = new PageWrapper<T>(page.getContent());
        wrapPage.setCurrentPage(page.getPageable().getPageNumber() + 1);
        wrapPage.setPageSize(page.getPageable().getPageSize());
        wrapPage.setTotalElements(page.getTotalElements());
        return wrapPage;
    }

    private PageWrapper(@NotNull List<T> data){
        this.data = data;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
