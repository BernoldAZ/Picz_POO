package Filters;

import java.util.ArrayList;
import java.util.List;

public class FilterFactory {

    private List<iFilterable> Allfilters = new ArrayList<>();

    public FilterFactory(){
        //Aqui se agregarian todos los filtros
        iFilterable BlackWhite = new BlackWhiteFilter();
        Allfilters.add(BlackWhite);
    }

    public iFilterable getFilter(int posFilter){
        return Allfilters.get(posFilter);
    }
}
