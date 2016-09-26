/*
 * Copyright 2016 Tamer AbdulRadi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package troy.macros

import troy.schema.Messages.{SchemaNotFound, QueryParseFailure}
import troy.schema.VTestUtils._
import org.scalatest.FreeSpec

class CqlOpsSpec extends FreeSpec {

  "CqlOps.parseQuery should" - {
    "fail with QueryParseFailure on wrong queries" in {
      CqlOps.parseQuery("NOT EVEN CQL QUERY").getError.asInstanceOf[QueryParseFailure]
    }
  }

  "CqlOps.parseSchemaFromPath should" - {
    "fail with SchemaNotFound on wrong path" in {
      CqlOps.loadOrParseSchema("/non_existent.cql").getError.asInstanceOf[SchemaNotFound]
    }
  }
}