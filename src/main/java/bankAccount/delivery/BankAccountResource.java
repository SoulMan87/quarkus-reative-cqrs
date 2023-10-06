package bankAccount.delivery;

import bankAccount.commands.BankAccountCommandService;
import bankAccount.commands.ChangeAddressCommand;
import bankAccount.commands.ChangeEmailCommand;
import bankAccount.commands.CreateBankAccountCommand;
import bankAccount.commands.DepositAmountCommand;
import bankAccount.dto.ChangeAddressRequestDTO;
import bankAccount.dto.ChangeEmailRequestDTO;
import bankAccount.dto.CreateBankAccountRequestDTO;
import bankAccount.dto.DepositAmountRequestDTO;
import bankAccount.queries.BankAccountQueryService;
import bankAccount.queries.FindAllByBalanceQuery;
import bankAccount.queries.GetBankAccountByIDQuery;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.opentracing.Traced;
import org.jboss.logging.Logger;

import java.util.Optional;

@Path(value = "/api/v1/bank")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BankAccountResource {

    private final static Logger logger = Logger.getLogger (BankAccountResource.class);

    @Inject
    BankAccountCommandService commandService;

    @Inject
    BankAccountQueryService queryService;

    @POST
    @Traced
    @Retry(maxRetries = 3, delay = 300)
    @Timeout(value = 5000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> createBankAccount(@Valid CreateBankAccountRequestDTO dto) {
        final var command = new CreateBankAccountCommand (dto.email (), dto.userName (), dto.address ());
        logger.infof ("CreateBankAccountCommand: %s", command);
        return commandService.handle (command).onItem ().transform (id -> Response.status (Response.Status.CREATED).entity (id).build ());
    }

    @POST
    @Path ("/email/{aggregateID}")
    @Traced
    @Retry(maxRetries = 3, delay = 300)
    @Timeout(value = 5000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> updateEmail(@PathParam("aggregateID") String aggregateID, @Valid ChangeEmailRequestDTO dto) {
        final var command = new ChangeEmailCommand (aggregateID, dto.newEmail ());
        logger.infof ("changeEmailCommand: %s", command);
        return commandService.handle (command).onItem ().transform (id -> Response.status (Response.Status.NO_CONTENT).build ());
    }

    @POST
    @Path("/address/{aggregateID}")
    @Traced
    @Retry(maxRetries = 3, delay = 300)
    @Timeout(value = 5000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> changeAddress(@PathParam("aggregateID") String aggregateID, @Valid ChangeAddressRequestDTO dto) {
        final var command = new ChangeAddressCommand(aggregateID, dto.newAddress());
        logger.infof("ChangeAddressCommand: %s", command);
        return commandService.handle(command).onItem().transform(id -> Response.status(Response.Status.NO_CONTENT).build());
    }

    @POST
    @Path("/deposit/{aggregateID}")
    @Traced
    @Retry(maxRetries = 3, delay = 300)
    @Timeout(value = 5000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> depositAmount(@PathParam("aggregateID") String aggregateID, @Valid DepositAmountRequestDTO dto) {
        final var command = new DepositAmountCommand (aggregateID, dto.amount());
        logger.infof("DepositAmountCommand: %s", command);
        return commandService.handle(command).onItem().transform(id -> Response.status(Response.Status.NO_CONTENT).build());
    }

    @GET
    @Path("{aggregateID}")
    @Traced
    @Retry(maxRetries = 3, delay = 300)
    @Timeout(value = 3000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> getBanAccount(@PathParam("aggregateID") String aggregateID) {
        final var query = new GetBankAccountByIDQuery (aggregateID);
        logger.infof("(HTTP getBanAccount) GetBankAccountByIDQuery: %s", query);
        return queryService.handle(query).onItem().transform(aggregate -> Response.status(Response.Status.OK).entity(aggregate).build());
    }

    @GET
    @Path("/balance")
    @Traced
    @Retry(maxRetries = 3, delay = 300)
    @Timeout(value = 3000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> getAllByBalance(@QueryParam("page") Optional<Integer> page, @QueryParam("size") Optional<Integer> size) {
        final var query = new FindAllByBalanceQuery (Page.of(page.orElse(0), size.orElse(5)));
        return queryService.handle(query).onItem().transform(result -> Response.status(Response.Status.OK).entity(result).build());
    }
}
