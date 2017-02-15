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

package troy
package driver.schema

import troy.tast.{ MaybeKeyspaceName, Identifier }
import troy.tutils.{ TNone, TSome }

/*
 * Name is expected to be a textual literal type
 * This type-class is meant to be instantiated at the call site (might be auto-generated by a macro/plugin)
 * to give the compiler a hint about the schema
 */
trait KeyspaceExists[Version, MaybeName <: MaybeKeyspaceName]

object KeyspaceExists {
  def instance[Version: VersionExists, Name <: Identifier] = new KeyspaceExists[Version, TSome[Name]] {}

  /**
   * Troy supports keyspace-agnostic, which means the whatever keyspace `use`ed at `session` level in runtime.
   * schema.cql should be keyspace-agnostic too in order for this to work
   */
  implicit def defaultKeyspace[Version: VersionExists] = new KeyspaceExists[Version, TNone] {}
}