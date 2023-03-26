package org.siit.homework.weel10.gate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.weel10.enums.TicketType;

import java.util.Queue;

class FestivalGateTest {
    private FestivalGate gate;

    @BeforeEach
    public void setUp() {
        gate = new FestivalGate();
    }

    @Test
    public void testValidateTicket() {
        gate.validateTicket(TicketType.FULL);
        Queue<TicketType> queue = gate.getTicketQueue();
        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals(TicketType.FULL, queue.poll());
    }
}