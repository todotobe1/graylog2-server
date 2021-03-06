/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog2.rest.models.system.indices;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.google.auto.value.AutoValue;
import org.graylog.autovalue.WithBeanGetter;
import org.graylog2.plugin.indexer.rotation.RotationStrategyConfig;

@JsonAutoDetect
@AutoValue
@WithBeanGetter
public abstract class RotationStrategyDescription {
    @JsonProperty("type")
    public abstract String type();

    @JsonProperty("default_config")
    public abstract RotationStrategyConfig defaultConfig();

    @JsonProperty("json_schema")
    public abstract JsonSchema jsonSchema();

    @JsonCreator
    public static RotationStrategyDescription create(@JsonProperty("type") String type,
                                                     @JsonProperty("default_config") RotationStrategyConfig defaultConfig,
                                                     @JsonProperty("json_schema") JsonSchema jsonSchema) {
        return new AutoValue_RotationStrategyDescription(type, defaultConfig, jsonSchema);
    }
}
