/*
Copyright 2009-2014 Igor Polevoy

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/

package org.javalite.ehcache_test;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Registry;
import org.javalite.activejdbc.cache.QueryCache;
import org.javalite.activejdbc.statistics.QueryStats;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.javalite.test.jspec.JSpec.a;
import static org.javalite.test.jspec.JSpec.the;

/**
 * @author Igor Polevoy
 */
public class RedisSpec {

    @Before
    public void before() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/activejdbc", "root", "p@ssw0rd");
        Base.exec("delete from people");
        for (int i = 0; i < 100; i++) {
            Person.create("name", "name: " + i, "last_name", "last_name: " + i, "dob", "1935-12-06").saveIt();
        }

    }

    @After
    public void after() {
        Base.close();
    }

    @Test
    public void shouldHitCache() {

        QueryCache.instance().purgeTableCache("people");
        Registry.instance().getStatisticsQueue().reset();

        Person.findAll().size();
        Person.findAll().size();


        List<QueryStats> queryStats = Registry.instance().getStatisticsQueue().getReportSortedBy("query");

        the(queryStats.size()).shouldBeEqual(1);

        QueryStats stats = queryStats.get(0);
        the(stats.getQuery()).shouldBeEqual("SELECT * FROM people");
        the(stats.getCount()).shouldBeEqual(1); // query was sent to DB only once!

    }
}
