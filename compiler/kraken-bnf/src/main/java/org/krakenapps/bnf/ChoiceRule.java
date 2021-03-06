/*
 * Copyright 2010 NCHOVY
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.krakenapps.bnf;

import java.nio.BufferUnderflowException;
import java.text.ParseException;

public class ChoiceRule implements Rule {
	private Rule[] rules;

	public ChoiceRule(Rule... rules) {
		this.rules = rules;
	}

	public Rule[] getRules() {
		return rules;
	}

	@Override
	public Result eval(String text, int position, ParserContext ctx) throws ParseException {
		for (Rule rule : rules) {
			try {
				return rule.eval(text, position, ctx);
			} catch (ParseException e) {
			} catch (BufferUnderflowException e) {
			}
		}

		throw new ParseException("syntax error, position " + position, position);
	}

	@Override
	public String toString() {
		return "choice (rule " + rules.length + ")";
	}

}
