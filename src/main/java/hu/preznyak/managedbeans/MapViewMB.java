package hu.preznyak.managedbeans;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "MapViewMB")
@SessionScoped
public class MapViewMB {
    private MapModel mapModel;
    private String centerMap = "47.534467, 21.624718";
    private String forSearch;

    @PostConstruct
    public void init(){
        mapModel = new DefaultMapModel();
    }

    public void onMapSearch(GeocodeEvent event){
        List<GeocodeResult> results = event.getResults();

        if(results != null && !results.isEmpty()){
            LatLng center = results.get(0).getLatLng();
            centerMap = center.getLat() + "," + center.getLng();

            for (int i=0;i<results.size();i++){
                GeocodeResult result = results.get(i);
                mapModel.addOverlay(new Marker(result.getLatLng(),result.getAddress()));
            }
        }
    }

    public String setAddressForSearch(String address){
        forSearch = address;
        return "/mapView";
    }

    public MapModel getMapModel() {
        return mapModel;
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public String getCenterMap() {
        return centerMap;
    }

    public void setCenterMap(String centerMap) {
        this.centerMap = centerMap;
    }

    public String getForSearch() {
        return forSearch;
    }

    public void setForSearch(String forSearch) {
        this.forSearch = forSearch;
    }
}
