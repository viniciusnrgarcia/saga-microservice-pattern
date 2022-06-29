/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package br.com.vnrg.sagaorderservice.openapi.api;

import br.com.vnrg.sagaorderservice.openapi.model.ModelApiResponse;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-28T23:00:05.420767756-03:00[America/Sao_Paulo]")
@Validated
@Tag(name = "order", description = "Order operations")
public interface OrderApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /order : Add a new order
     * Add a new order
     *
     * @param order Create a new Order (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 405)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "addOrder",
        summary = "Add a new order",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ModelApiResponse.class))
            }),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/order",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ModelApiResponse> _addOrder(
        @Parameter(name = "Order", description = "Create a new Order", required = true) @Valid @RequestBody Order order
    ) {
        return addOrder(order);
    }

    // Override this method
    default  ResponseEntity<ModelApiResponse> addOrder(Order order) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"type\" : \"type\", \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /order/{orderId} : Deletes a Order
     * Delete an existent Order by Id
     *
     * @param orderId Order id to delete (required)
     * @return Successful operation (status code 200)
     *         or Invalid Order Id (status code 400)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "deleteOrder",
        summary = "Deletes a Order",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ModelApiResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Order Id"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/order/{orderId}",
        produces = { "application/json" }
    )
    default ResponseEntity<ModelApiResponse> _deleteOrder(
        @Parameter(name = "orderId", description = "Order id to delete", required = true) @PathVariable("orderId") UUID orderId
    ) {
        return deleteOrder(orderId);
    }

    // Override this method
    default  ResponseEntity<ModelApiResponse> deleteOrder(UUID orderId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"type\" : \"type\", \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /order : Update an existent Order
     * Update an existent Order by Id
     *
     * @param order Update an existent Order (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     *         or Validation exception (status code 405)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "updateOrder",
        summary = "Update an existent Order",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ModelApiResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Order not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/order",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ModelApiResponse> _updateOrder(
        @Parameter(name = "Order", description = "Update an existent Order", required = true) @Valid @RequestBody Order order
    ) {
        return updateOrder(order);
    }

    // Override this method
    default  ResponseEntity<ModelApiResponse> updateOrder(Order order) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"type\" : \"type\", \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
