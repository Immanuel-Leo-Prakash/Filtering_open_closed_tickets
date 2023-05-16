import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ArgumentProvider {

    private static Stream<Arguments> ContraryArgProvider() {
        return Stream.of(
                Arguments.arguments(Builder.OpenFilter(), Builder.CloseFilter()),
                Arguments.arguments(Builder.OpenFilter(), Builder.OnHoldFilter()),
                Arguments.arguments(Builder.OpenFilter(), Builder.EscalatedFilter()),
                Arguments.arguments(Builder.CloseFilter(), Builder.OpenFilter()),
                Arguments.arguments(Builder.CloseFilter(), Builder.OnHoldFilter()),
                Arguments.arguments(Builder.CloseFilter(), Builder.EscalatedFilter()),
                Arguments.arguments(Builder.OnHoldFilter(), Builder.OpenFilter()),
                Arguments.arguments(Builder.OnHoldFilter(), Builder.CloseFilter()),
                Arguments.arguments(Builder.OnHoldFilter(), Builder.EscalatedFilter()),
                Arguments.arguments(Builder.EscalatedFilter(), Builder.OpenFilter()),
                Arguments.arguments(Builder.EscalatedFilter(), Builder.CloseFilter()),
                Arguments.arguments(Builder.EscalatedFilter(), Builder.OnHoldFilter())
        );
    }

    private static Stream<Arguments> NullArgInFiltering() {
        return Stream.of(
                Arguments.arguments(Builder.OpenFilter(), null),
                Arguments.arguments(Builder.CloseFilter(), null),
                Arguments.arguments(Builder.OnHoldFilter(), null),
                Arguments.arguments(Builder.EscalatedFilter(), null)

        );
    }

    private static Stream<Arguments> TicketTestArgProvider() {
        return Stream.of(
                Arguments.arguments(null, Tickets.TicketStatus.OPEN, Builder.DepartmentBuilder()),
                Arguments.arguments(Builder.AgentBuilder(), null, Builder.DepartmentBuilder()),
                Arguments.arguments(Builder.AgentBuilder(), Tickets.TicketStatus.OPEN, null)

        );
    }

}

