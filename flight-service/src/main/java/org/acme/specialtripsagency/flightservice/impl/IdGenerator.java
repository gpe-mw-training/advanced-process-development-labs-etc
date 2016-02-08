package org.acme.specialtripsagency.flightservice.impl;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class IdGenerator {
  private SecureRandom random = new SecureRandom();

  public String nextId() {
    return new BigInteger(50, random).toString(32);
  }
}