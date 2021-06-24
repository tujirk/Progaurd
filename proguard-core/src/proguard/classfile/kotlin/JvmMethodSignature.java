/*
 * ProGuardCORE -- library to process Java bytecode.
 *
 * Copyright (c) 2002-2020 Guardsquare NV
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package proguard.classfile.kotlin;

import java.util.Objects;

/**
 * @author james
 */
public class JvmMethodSignature
{
    private final String name;
    private final String desc;

    public JvmMethodSignature(String name, String desc)
    {
        this.name = name;
        this.desc = desc;
    }

    public String getName()
    {
        return name;
    }

    public String getDesc()
    {
        return desc;
    }

    public String asString()
    {
        return name + desc;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        JvmMethodSignature that = (JvmMethodSignature)o;
        return name.equals(that.name) && desc.equals(that.desc);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, desc);
    }

    @Override
    public String toString()
    {
        return this.name + this.desc;
    }

    // Helper methods to convert from/to Kotlin metadata classes.

    public static JvmMethodSignature fromKotlinJvmMethodSignature(kotlinx.metadata.jvm.JvmMethodSignature jvmMethodSignature)
    {
        if (jvmMethodSignature == null)
        {
            return null;
        }

        return new JvmMethodSignature(jvmMethodSignature.getName(), jvmMethodSignature.getDesc());
    }

    public static kotlinx.metadata.jvm.JvmMethodSignature toKotlinJvmMethodSignature(JvmMethodSignature jvmMethodSignature)
    {
        if (jvmMethodSignature == null)
        {
            return null;
        }

        return new kotlinx.metadata.jvm.JvmMethodSignature(jvmMethodSignature.name, jvmMethodSignature.desc);
    }
}
