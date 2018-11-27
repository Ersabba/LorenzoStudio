package datatable.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

@ParentPackage("json-default")
@Action(value = "LoadDataTable", results = {@Result(name="SUCCESS",type="json") })
@Namespaces(value={@Namespace("/")})
public class LoadDataTable extends ActionSupport {

    Integer draw;
    Integer recordsTotal;
    Integer recordsFiltered;
    String[][] data;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public String execute(){
        draw = 1;
        recordsTotal=1;
        recordsFiltered=1;

        data = new String[1][6];
        data[0][0]="Lorenzo";
        data[0][1]="Sabbatini";
        data[0][2]="Roma";
        data[0][3]="Software Engineer";
        data[0][4]="11 Nov 2018";
        data[0][5]="100000";

        return "SUCCESS";
    }

}
