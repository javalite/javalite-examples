package app.controllers;

import org.javalite.activejdbc.Registry;
import org.javalite.activejdbc.statistics.QueryStats;
import org.javalite.activeweb.AppController;

import java.util.List;

/**
 * @author Igor Polevoy on 2/16/16.
 */
public class StatsController extends AppController {
    public void index(){
        view("stats", Registry.instance().getStatisticsQueue().getReportSortedBy(param("s")));
    }
}
