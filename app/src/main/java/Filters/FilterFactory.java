package Filters;

import java.util.ArrayList;
import java.util.List;

public class FilterFactory {

   // private List<iFilterable> Allfilters = new ArrayList<>();

    public FilterFactory(int ){
        //Aqui se agregarian todos los filtros
        if()iFilterable BlackWhite = new BlackWhiteFilter();
     //   Allfilters.add(BlackWhite);

        iFilterable Gaussian = new GaussianFilter();
       // Allfilters.add(Gaussian);

        iFilterable Sharp = new SharpFilter();
        //Allfilters.add(Sharp);
    }

    /*public iFilterable getFilter(int posFilter){
        return Allfilters.get(posFilter);
    }
*/}
