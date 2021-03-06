package team.koala.chillin.client;

import team.koala.chillin.client.helper.parser.Parser;


public class Protocol {

	private Network network;
	private Parser parser;


	public Protocol(Network network) {
		this.network = network;
		this.parser = new Parser();
	}

	public void sendMessage(KSObject msg) {
		byte[] data = parser.encode(msg);
		network.sendData(data);
	}

	public KSObject recvMessage() {
		byte[] data = network.recvData();
		if (data.length == 0)
			return null;

		KSObject msg = parser.decode(data);
		return msg;
	}
}
