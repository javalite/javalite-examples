package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.json.JSONMap;

import java.util.Map;

import static org.javalite.common.Collections.map;

public class PetController extends AppController {

    @POST("""
            {
                    "tags": [
                      "pet"
                    ],
                    "summary": "Add a new pet to the store",
                    "description": "",
                    "operationId": "addPet",
                    "consumes": [
                      "application/json",
                      "application/xml"
                    ],
                    "produces": [
                      "application/xml",
                      "application/json"
                    ],
                    "parameters": [
                      {
                        "in": "body",
                        "name": "body",
                        "description": "Pet object that needs to be added to the store",
                        "required": true,
                        "schema": {
                          "$ref": "#/definitions/Pet"
                        }
                      }
                    ],
                    "responses": {
                      "405": {
                        "description": "Invalid input"
                      }
                    },
                    "security": [
                      {
                        "petstore_auth": [
                          "write:pets",
                          "read:pets"
                        ]
                      }
                    ]
            }
            """)
    public void add() { }

    @PUT("""
             {
                    "tags": [
                      "pet"
                    ],
                    "summary": "Update an existing pet",
                    "description": "",
                    "operationId": "updatePet",
                    "consumes": [
                      "application/json",
                      "application/xml"
                    ],
                    "produces": [
                      "application/xml",
                      "application/json"
                    ],
                    "parameters": [
                      {
                        "in": "body",
                        "name": "body",
                        "description": "Pet object that needs to be added to the store",
                        "required": true,
                        "schema": {
                          "$ref": "#/definitions/Pet"
                        }
                      }
                    ],
                    "responses": {
                      "400": {
                        "description": "Invalid ID supplied"
                      },
                      "404": {
                        "description": "Pet not found"
                      },
                      "405": {
                        "description": "Validation exception"
                      }
                    },
                    "security": [
                      {
                        "petstore_auth": [
                          "write:pets",
                          "read:pets"
                        ]
                      }
                    ]
                  }
            """)
    public void update() { }

    @GET("""
            {
                    "tags": [
                      "pet"
                    ],
                    "summary": "Finds Pets by status",
                    "description": "Multiple status values can be provided with comma separated strings",
                    "operationId": "findPetsByStatus",
                    "produces": [
                      "application/xml",
                      "application/json"
                    ],
                    "parameters": [
                      {
                        "name": "status",
                        "in": "query",
                        "description": "Status values that need to be considered for filter",
                        "required": true,
                        "type": "array",
                        "items": {
                          "type": "string",
                          "enum": [
                            "available",
                            "pending",
                            "sold"
                          ],
                          "default": "available"
                        },
                        "collectionFormat": "multi"
                      }
                    ],
                    "responses": {
                      "200": {
                        "description": "successful operation",
                        "schema": {
                          "type": "array",
                          "items": {
                            "$ref": "#/definitions/Pet"
                          }
                        }
                      },
                      "400": {
                        "description": "Invalid status value"
                      }
                    },
                    "security": [
                      {
                        "petstore_auth": [
                          "write:pets",
                          "read:pets"
                        ]
                      }
                    ]
                  }  
            """)
    public void findByStatus() {}

    @GET("""
            {
                    "tags": [
                      "pet"
                    ],
                    "summary": "Find pet by ID",
                    "description": "Returns a single pet",
                    "operationId": "getPetById",
                    "produces": [
                      "application/xml",
                      "application/json"
                    ],
                    "parameters": [
                      {
                        "name": "petId",
                        "in": "path",
                        "description": "ID of pet to return",
                        "required": true,
                        "type": "integer",
                        "format": "int64"
                      }
                    ],
                    "responses": {
                      "200": {
                        "description": "successful operation",
                        "schema": {
                          "$ref": "#/definitions/Pet"
                        }
                      },
                      "400": {
                        "description": "Invalid ID supplied"
                      },
                      "404": {
                        "description": "Pet not found"
                      }
                    },
                    "security": [
                      {
                        "api_key": []
                      }
                    ]
                  }
            """)
    public void getPet(){
        String  petId = param("petId");

        //lets pretend we found a pet:
        JSONMap pet = new JSONMap(map("name", "Barker", "species", "dog"));
        respond(pet.toJSON()).contentType("application/json");
    }


    @POST("""
            {
                    "tags": [
                      "pet"
                    ],
                    "summary": "Updates a pet in the store with form data",
                    "description": "",
                    "operationId": "updatePetWithForm",
                    "consumes": [
                      "application/x-www-form-urlencoded"
                    ],
                    "produces": [
                      "application/xml",
                      "application/json"
                    ],
                    "parameters": [
                      {
                        "name": "petId",
                        "in": "path",
                        "description": "ID of pet that needs to be updated",
                        "required": true,
                        "type": "integer",
                        "format": "int64"
                      },
                      {
                        "name": "name",
                        "in": "formData",
                        "description": "Updated name of the pet",
                        "required": false,
                        "type": "string"
                      },
                      {
                        "name": "status",
                        "in": "formData",
                        "description": "Updated status of the pet",
                        "required": false,
                        "type": "string"
                      }
                    ],
                    "responses": {
                      "405": {
                        "description": "Invalid input"
                      }
                    },
                    "security": [
                      {
                        "petstore_auth": [
                          "write:pets",
                          "read:pets"
                        ]
                      }
                    ]
            }
            """)
    public void updatePet(){
          Map form  = params1st();
        //...
    }

    @DELETE
    public void deletePet(){
        String petId  = getId();
        //...
    }
}
