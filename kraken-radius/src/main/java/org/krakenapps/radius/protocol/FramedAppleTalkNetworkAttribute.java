/*
 * Copyright 2011 Future Systems
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
package org.krakenapps.radius.protocol;

public class FramedAppleTalkNetworkAttribute extends RadiusAttribute {
	
	private int address;
	
	public FramedAppleTalkNetworkAttribute(int address) {
		this.address = address;
	}
	
	public FramedAppleTalkNetworkAttribute(byte[] encoded, int offset, int length) {
		if (encoded[offset] != getType())
			throw new IllegalArgumentException("binary is not framed apple talk network attribute");
		
		this.address = decodeInt(encoded, offset, length);
	}
	
	@Override
	public int getType() {
		return 38;
	}

	public int getAddress() {
		return address;
	}
	
	@Override
	public byte[] getBytes() {
		return encodeInt(getType(), address);
	}
}
