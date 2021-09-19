package com.example.autenticacaojwt.swagger;

import com.example.autenticacaojwt.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API").select()
                .apis(RequestHandlerSelectors.basePackage("com.example.autenticacaojwt"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .globalResponseMessage(RequestMethod.GET, responseMessageBuilders())
                .ignoredParameterTypes(User.class)
                .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Authorization")
                                .defaultValue("Bearer ")
                                .description("Header p/ facilitar o envio do Authorization Bearer Token")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()));
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Mateus Braz", null, "silvabraz96@gmail.com");
        return new ApiInfoBuilder()
                .title("API Documentation")
                .description("Esta é a documentação interativa do Rest API. Tente enviar algum request.")
                .contact(contact)
                .build();
    }

    private List<ResponseMessage> responseMessageBuilders() {
        return Arrays.asList(
                new ResponseMessageBuilder()
                        .code(500)
                        .message("Erro interno no servidor")
                        .build(),
                new ResponseMessageBuilder()
                        .code(403)
                        .message("Forbidden! Você não pode acessar este recurso")
                        .build(),
                new ResponseMessageBuilder()
                        .code(404)
                        .message("O recurso que você buscou não foi encontrado")
                        .build()
        );
    }
}
