package com.optimaize.soapworks.exampleproject.server.services.rest.system.ping;

import com.google.common.base.Optional;
import com.optimaize.command4j.Command;
import com.optimaize.command4j.ExecutionContext;
import com.optimaize.command4j.commands.BaseCommand;
import com.optimaize.soapworks.exampleproject.server.lib.BaseWebService;
import com.optimaize.soapworks.server.rest.Envelope;
import com.optimaize.soapworks.server.rest.RestWebService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 */
@Service
@Path("/v1/system")
public class RestPingService extends BaseWebService implements RestWebService {

    @GET
    @Path("/ping")
    @Produces({"application/json"})
    public Response ping(
            @QueryParam(value = "apiKey") final String apiKey,
            @QueryParam(value = "envelope") final boolean envelope
    ) {
        String result = execute(new BaseCommand<Object, String>() {
            @Override
            public String call(@NotNull Optional<Object> arg, @NotNull ExecutionContext ec) throws Exception {
                return "pong";
            }
        }).orNull();

        Object entity = result;
        if (envelope) {
            entity = Envelope.success(entity);
        }
        return Response.ok().entity(entity).build();

    }

    @NotNull
    protected Optional<String> execute(Command<Object, String> command) {
        return restExceptionBarrier(command, modeFactory.restDefaultMode(), null);
    }

}
