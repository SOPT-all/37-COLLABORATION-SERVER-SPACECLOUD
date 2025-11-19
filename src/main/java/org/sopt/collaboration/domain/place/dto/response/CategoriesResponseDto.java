package org.sopt.collaboration.domain.place.dto.response;

import org.sopt.collaboration.domain.place.entity.Filter;
import org.sopt.collaboration.domain.place.entity.enums.filter.FilterCategory;

import java.util.ArrayList;
import java.util.List;

public record CategoriesResponseDto(
        List<CategoryItem> workspace,
        List<CategoryItem> gathering
) {

    public static CategoriesResponseDto from(List<Filter> filters) {

        List<CategoryItem> workspace = new ArrayList<>();
        List<CategoryItem> gathering = new ArrayList<>();

        for (Filter filter : filters) {
            if (filter.getFilterCategory() == FilterCategory.WORKSPACE) {
                workspace.add(CategoryItem.from(filter));
            } else if (filter.getFilterCategory() == FilterCategory.GATHERING) {
                gathering.add(CategoryItem.from(filter));
            }
        }

        return new CategoriesResponseDto(workspace, gathering);
    }

    public record CategoryItem(
            String name
    ){
        public static CategoryItem from(Filter filter) {
            return new CategoryItem(
                    filter.getName()
            );
        }
    }

}
