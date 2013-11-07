/**
Open Bank Project - API
Copyright (C) 2011, 2013, TESOBE / Music Pictures Ltd

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

Email: contact@tesobe.com
TESOBE / Music Pictures Ltd
Osloerstrasse 16/17
Berlin 13359, Germany

  This product includes software developed at
  TESOBE (http://www.tesobe.com/)
  by
  Simon Redfern : simon AT tesobe DOT com
  Stefan Bethge : stefan AT tesobe DOT com
  Everett Sochowski : everett AT tesobe DOT com
  Ayoub Benali: ayoub AT tesobe DOT com

 */
package code.util

import com.rabbitmq.client.{ConnectionFactory,Channel}
import net.liftmodules.amqp.{AMQPSender,StringAMQPSender,AMQPMessage}
import scala.actors._

object ResponseSender {
  val factory = new ConnectionFactory {
    import ConnectionFactory._

    setHost(DEFAULT_HOST)
    setPort(DEFAULT_AMQP_PORT)
    setUsername(DEFAULT_USER)
    setPassword(DEFAULT_PASS)
    setVirtualHost(DEFAULT_VHOST)
  }

  //StringAMQPSender(ConnectionFactory, EXCHANGE, QUEUE_ROUTING_KEY)
  val amqp = new StringAMQPSender(factory, "directExchange2", "response")

  def sendMessage(message: String) = {  //string
     amqp ! AMQPMessage(message)
  }
}

// class StringAMQPSender(cf: ConnectionFactory, exchange: String, routingKey: String)
//  extends AMQPSender[String](cf, exchange, routingKey) {   //string
//   override def configure(channel: Channel) = {
//     val conn = cf.newConnection()
//     val channel = conn.createChannel()
//     channel
//   }
// }