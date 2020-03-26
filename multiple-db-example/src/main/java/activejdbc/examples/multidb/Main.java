/*
Copyright 2009-2010 Igor Polevoy

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
package activejdbc.examples.multidb;

import org.javalite.activejdbc.DB;

public class Main {
    public static void main(String[] args) {
        DB d1 = new DB("ep");
        d1.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/pigeon_development", "root", "p@ssw0rd");
        DB d2 = new DB("jes");
        d2.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/jes_development", "root", "p@ssw0rd");
        System.out.println("I have: " + Inmate.count() + " inmates");
        System.out.println("I have: " + User.count() + " users");
        new DB("ep").close();
        new DB("jes").close();
    }
}
