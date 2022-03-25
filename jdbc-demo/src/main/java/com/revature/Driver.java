package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.models.Boba;
import com.revature.services.BobaNotFoundException;
import com.revature.services.BobaService;

import io.javalin.Javalin;

public class Driver {
			
	private static List<Boba> bobas = new ArrayList<>();
			public static void main(String[] args) {
				BobaService is = new BobaService();
				
				Javalin app = Javalin.create();
				app.start();
				
				app.get("boba",(ctx) ->{
					ctx.status(256);
					
					ctx.result("hello world, I am here to serve you");
				});
				// get the boba item by id
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
				
				app.post("boba", (ctx)->{
					Boba b = ctx.bodyAsClass(Boba.class);
					bobas.add(b);
					ctx.status(HttpStatus.CREATED_201);
						});
				
				// get boba item by flavor
				app.get("boba/{flavor_name}", (ctx) ->{
					
					String name  =ctx.pathParam("flavor_name");
					try {
						Boba boba = is.getByName(name);
						ctx.json(boba);
						ctx.status(200);
						
					}catch ( BobaNotFoundException e) {
						ctx.status(400);
						ctx.result("Hellooooo Dear, Please visit us next time");
					}
			});
				

	}

}
