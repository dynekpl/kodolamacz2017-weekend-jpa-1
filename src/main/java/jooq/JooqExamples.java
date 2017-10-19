package jooq;

//For convenience, always static import your generated tables and jOOQ functions to decrease verbosity:

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static generated.Tables.NOTEBOOKS;

public class JooqExamples {

    public static void main(String[] args) {
        String user = "sa";
        String password = "";
        String url = "jdbc:h2:~/test";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            DSLContext context = DSL.using(connection, SQLDialect.H2);

            //selectAll(context);

            //SelectConditionStep<Record> select = context.select().from(NOTEBOOKS).where(NOTEBOOKS.RESOLUTION.ge(1600));
            //System.out.println(select.getSQL());
            //Result<Record> results = select.fetch();
            //System.out.println(results.formatInsert());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAll(DSLContext context) {
        Result<Record> results = context.select().from(NOTEBOOKS).fetch();

        for (Record r : results) {
            Integer id = r.getValue(NOTEBOOKS.ID);
            String model = r.getValue(NOTEBOOKS.MODEL);
            Integer resolution = r.getValue(NOTEBOOKS.RESOLUTION);

            System.out.println("ID " + id + " model " + model + " resolution " + resolution);
        }
    }
}
