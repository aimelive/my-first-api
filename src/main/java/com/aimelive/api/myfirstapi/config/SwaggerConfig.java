package com.aimelive.api.myfirstapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Aime Ndayambaje",
                        email = "aimendayambaje24@gmail.com",
                        url = "https://my-first-api.up.railway.app/"
                ),
                description = "Swagger Documentation for My First API",
                title = "My First API - Backend",
                version = "1.0.0",
                license = @License(
                        name = "MIT License",
                        url = "https://some-url.com"
                ),
                termsOfService = "https://some-url.com"

        ),
        servers = {
                @Server(
                        description = "Prod ENV",
                        url = "https://my-first-api.up.railway.app"
                ),
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),

        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT authentication token",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}
