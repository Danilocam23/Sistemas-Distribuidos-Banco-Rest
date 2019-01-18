/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebRestApi;

import WebServices_DB.OperacionesDB;
import javafx.scene.media.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author xcojcama
 */
@Path("/Debito")
public class RestDebito {

    @GET
    @Path("/{cuenta}/{dinero}")
    public String Debito(@PathParam("cuenta") String c, @PathParam("dinero") int d) {
        OperacionesDB odb = new OperacionesDB();
        return odb.Transacion(c, d);
    }
}
