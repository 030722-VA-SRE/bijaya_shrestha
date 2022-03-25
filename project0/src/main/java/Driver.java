import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.daos.BobaPostgres;
import com.revature.models.Boba;
import com.revature.services.BobaNotFoundException;
import com.revature.services.BobaService;

import io.javalin.Javalin;

public class Driver {

	private static List<Boba> bobas = new ArrayList<>();
			public static void main(String[] args) {
				BobaService is = new BobaService();
				BobaPostgres p = new BobaPostgres();
				Javalin app = Javalin.create();
				app.start();
				
				
				//retrive all bobas using flavor name or id,
				app.get("boba",(ctx) ->{

					String boba = ctx.queryParam("boba");
					String price = ctx.queryParam("price");
					try {
						if(boba == null && price == null) {
							ctx.json(p.getAllBoba());
							}
						else if(boba == null && price == null) {
							ctx.json(is.getByName(boba));
							}
						
						} catch(BobaNotFoundException e) {
							ctx.status(256);
							ctx.result("Sorry,not avaiable.");
						}
					});
//					ctx.status(256);		
//				ctx.json(is.getAllBoba());  // display the list of all items by using getAllBoba method. 
//				});
//				
				
				
				//  retrieving boba item by using id only.
				app.get("boba/{id}", (ctx) ->{
			
					int id = Integer.parseInt(ctx.pathParam("id"));
					try {
						Boba boba = is.getById(id);
						ctx.json(boba);
						ctx.status(200);
						
					}catch ( BobaNotFoundException e) {
						ctx.status(400);		
						ctx.result("Hellooooo Dear, Please visit us next time");
					}
			});
				
				// get boba item by flavor
				app.get("boba/{flavor_name}", (ctx) ->{
					
					String name  =ctx.pathParam("flavor_name");
					try {
						Boba boba = is.getByName(name);
						ctx.status(200);
						ctx.json(boba);
					}catch ( BobaNotFoundException e) {
						ctx.status(400);
						ctx.result("boba is not found, Please try again");
					}
					});
				
				 //Post item(boba) to the database;   sending appropriate HTTP response based on outcome
				app.post("boba", (ctx) -> {
					Boba newboba = ctx.bodyAsClass(Boba.class);
					try {
						is.addboba(newboba);
						ctx.status(HttpStatus.CREATED_201);
						ctx.result("added a boba in the database" +newboba);

					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				
				});
				
				//update the database with new boba record. Put is the keywords for updating the server database.
				app.put("boba", (ctx)->{
					
					try {
						Boba updateBoba = ctx.bodyAsClass(Boba.class);
						is.addboba(updateBoba);
						ctx.status(HttpStatus.CREATED_201);
						ctx.result(" update a boba in the database");

					} catch (NumberFormatException e) {
						e.printStackTrace();
						}
						});
				
				// delete the boba records from the database using delete keywords.		
				app.delete("boba", (ctx)->{
						int id = Integer.parseInt(ctx.pathParam("id"));
						boolean boba = is.deleteBoba(id);
						
						ctx.status(200);
						ctx.result("deleted successfully!");
					});
			}
}

			
