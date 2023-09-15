package configuration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {@Tag(name = "Bank Account", description = "Bank account operations.")},
        info = @Info(
                title = "Quarkus CQRS Reactive Microservice",
                version = "1.0.0",
                contact = @Contact(
                        name = "Jonathan Hinestroza",
                        url = "https://github.com/SoulMan87",
                        email = "jonathanhinestroza87@gmail.com"
                ))
)
@ApplicationScoped
public class SwaggerOpenApiConfiguration extends Application {


}
