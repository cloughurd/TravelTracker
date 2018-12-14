package modelStorage;

import java.util.ArrayList;
import java.util.List;

import models.pointsOfInterest.IPlottable;
import models.pointsOfInterest.PlottableType;
import models.pointsOfInterest.TemplePlottable;

public class TempleHolder {
    private List<TemplePlottable> templeList;

    public TempleHolder(){
        templeList = new ArrayList<>();
    }

    public List<IPlottable> getIPlottableList(){
        List<IPlottable> reDoneList = new ArrayList<>();
        for(TemplePlottable temple: templeList){
            if(temple == null){
                System.err.println(temple);
                continue;
            }
            temple.setType(PlottableType.TEMPLE);
            temple.setVisited(false);
            reDoneList.add(temple);
        }
        System.out.println("Size of list: " + reDoneList.size());
        return reDoneList;
    }

    public List<TemplePlottable> getTempleList() {
        return templeList;
    }

    public void setTemplelist(ArrayList<TemplePlottable> templelist) {
        this.templeList = templelist;
    }

    public void addTemple(TemplePlottable temple){
        templeList.add(temple);
    }
}
