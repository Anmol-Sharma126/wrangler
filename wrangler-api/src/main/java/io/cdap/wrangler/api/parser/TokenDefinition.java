/*
 * Copyright © 2017-2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.cdap.wrangler.api.parser;

import io.cdap.wrangler.api.annotations.PublicEvolving;

import java.io.Serializable;

/**
 * Represents a definition of a token used in directive usage specifications.
 * Instances of this class are immutable and define the name, type, position (ordinal),
 * label, and whether the token is optional.
 *
 * This structure supports all token types defined in {@link TokenType}, including
 * the newly added {@code BYTE_SIZE} and {@code TIME_DURATION} for parsing
 * values like "10KB" or "250ms".
 *
 * Example:
 * <pre>{@code
 * TokenDefinition token = new TokenDefinition("limit", TokenType.BYTE_SIZE, "Memory Limit", 1, false);
 * }</pre>
 */
@PublicEvolving
public final class TokenDefinition implements Serializable {
  private final int ordinal;
  private final boolean optional;
  private final String name;
  private final TokenType type;
  private final String label;

  /**
   * Creates a new TokenDefinition instance.
   *
   * @param name     the name of the token
   * @param type     the {@link TokenType} of the token (e.g., BYTE_SIZE, TIME_DURATION)
   * @param label    optional label used in usage documentation
   * @param ordinal  the position of this token in the directive's parameter list
   * @param optional whether the token is optional
   */
  public TokenDefinition(String name, TokenType type, String label, int ordinal, boolean optional) {
    this.name = name;
    this.type = type;
    this.label = label;
    this.ordinal = ordinal;
    this.optional = optional;
  }

  /**
   * @return the label associated with this token, or {@code null} if none
   */
  public String label() {
    return label;
  }

  /**
   * @return the position of this token in the directive’s parameter list
   */
  public int ordinal() {
    return ordinal;
  }

  /**
   * @return {@code true} if the token is optional, {@code false} otherwise
   */
  public boolean optional() {
    return optional;
  }

  /**
   * @return the name of the token
   */
  public String name() {
    return name;
  }

  /**
   * @return the {@link TokenType} of the token
   */
  public TokenType type() {
    return type;
  }
}
