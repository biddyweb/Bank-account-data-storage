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
package com.tesobe.model

/**
 * Holds the configuration of an account.
 *
 * @param bank the bank code of this account (e.g. "10010010" for Postbank)
 * @param account the account number of this account (e.g. "12345")
 * @param pinData the encrypted PIN for this account
 */
case class AccountConfig(
  holder: String,
  blz: String,
  account_number: String,
  pin: String
)

/**
 * Holds the transaction data that is to be pushed to the OBP API.
 */
case class OBPTransactionWrapper(
  obp_transaction: OBPTransaction)

case class OBPTransaction(
  this_account: OBPAccount,
  other_account: OBPAccount,
  details: OBPDetails)

case class OBPAccount(
  holder: String,
  number: String,
  iban: String,
  kind: String,
  bank: OBPBank)

case class OBPBank(
  bic: String,
  national_identifier: String,
  name: String)

case class OBPDetails(
  trans_type: String,
  posted: OBPDate,
  completed: OBPDate,
  new_balance: OBPAmount,
  value: OBPAmount,
  label: String,
  other_data: String)

case class OBPDate(`$dt`: String)

case class OBPAmount(
  currency: String,
  amount: String) {
  override def toString = "OBPAmount(" + currency + ",***)"
}
