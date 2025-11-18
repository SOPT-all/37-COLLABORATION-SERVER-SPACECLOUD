package org.sopt.collaboration.domain.place.dto.response;

import org.sopt.collaboration.domain.place.entity.Filter;

import java.util.List;

public record CategoriesResponseDto(
        List<CategoryItem> workspace,
        List<CategoryItem> gathering
) {
    public record CategoryItem(
            String code,
            String name
    ){
        public static CategoryItem from(Filter filter) {
            return new CategoryItem(
                    filter.getCode(),
                    filter.getName()
            );
        }
    }
}
