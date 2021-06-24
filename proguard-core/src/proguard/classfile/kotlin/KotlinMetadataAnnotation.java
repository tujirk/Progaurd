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

import kotlinx.metadata.*;
import proguard.classfile.*;
import proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor;
import proguard.util.*;

import java.util.Map;

public class KotlinMetadataAnnotation
extends      SimpleProcessable
implements   Processable
{
    public KmAnnotation kmAnnotation;
    public Clazz        referencedAnnotationClass;

    // Keys correspond to methods in Java class files.
    public Map<String, Method> referencedArgumentMethods;

    public KotlinMetadataAnnotation(KmAnnotation kmAnnotation)
    {
        this.kmAnnotation = kmAnnotation;
    }


    public void accept(Clazz clazz, KotlinTypeMetadata kotlinTypeMetadata, KotlinAnnotationVisitor kotlinAnnotationVisitor)
    {
        kotlinAnnotationVisitor.visitTypeAnnotation(clazz, kotlinTypeMetadata, this);
    }


    public void accept(Clazz clazz, KotlinTypeAliasMetadata kotlinTypeAliasMetadata, KotlinAnnotationVisitor kotlinAnnotationVisitor)
    {
        kotlinAnnotationVisitor.visitTypeAliasAnnotation(clazz, kotlinTypeAliasMetadata, this);
    }


    public void accept(Clazz clazz, KotlinTypeParameterMetadata kotlinTypeParameterMetadata, KotlinAnnotationVisitor kotlinAnnotationVisitor)
    {
        kotlinAnnotationVisitor.visitTypeParameterAnnotation(clazz, kotlinTypeParameterMetadata, this);
    }

    // Implementations for Object.
    @Override
    public String toString()
    {
        return kmAnnotation.getClassName() + "(" + kmAnnotation.getArguments() + ")";
    }
}
