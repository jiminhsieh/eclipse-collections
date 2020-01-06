/*
 * Copyright (c) 2019 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.factory.bag;

import java.util.stream.Stream;

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.factory.Bags;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;

/**
 * A factory which creates instances of type {@link ImmutableBag}.
 */
public interface ImmutableBagFactory
{
    /**
     * @since 6.0
     */
    <T> ImmutableBag<T> empty();

    /**
     * Same as {@link #empty()}.
     */
    <T> ImmutableBag<T> of();

    /**
     * Same as {@link #empty()}.
     */
    <T> ImmutableBag<T> with();

    /**
     * Same as {@link #with(Object)}.
     */
    <T> ImmutableBag<T> of(T element);

    <T> ImmutableBag<T> with(T element);

    /**
     * Same as {@link #with(Object[])}.
     */
    <T> ImmutableBag<T> of(T... elements);

    default <T> ImmutableBag<T> ofOccurrences(T element, int occurrence)
    {
        return this.withOccurrences(element, occurrence);
    }

    default <T> ImmutableBag<T> ofOccurrences(T element1, int occurrence1, T element2, int occurrence2)
    {
        return this.withOccurrences(element1, occurrence1, element2, occurrence2);
    }

    default <T> ImmutableBag<T> ofOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3)
    {
        return this.withOccurrences(element1, occurrence1, element2, occurrence2, element3, occurrence3);
    }

    default <T> ImmutableBag<T> ofOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3, T element4, int occurrence4)
    {
        return this.withOccurrences(element1, occurrence1, element2, occurrence2, element3, occurrence3, element4, occurrence4);
    }

    default <T> ImmutableBag<T> ofOccurrences(ObjectIntPair<T>... elementsWithOccurrences)
    {
        return this.withOccurrences(elementsWithOccurrences);
    }

    <T> ImmutableBag<T> with(T... elements);

    <T> ImmutableBag<T> withOccurrences(T element, int occurrence);

    <T> ImmutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2);

    <T> ImmutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3);

    <T> ImmutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3, T element4, int occurrence4);

    <T> ImmutableBag<T> withOccurrences(ObjectIntPair<T>... elementsWithOccurrences);

    /**
     * Same as {@link #withAll(Iterable)}.
     */
    <T> ImmutableBag<T> ofAll(Iterable<? extends T> items);

    <T> ImmutableBag<T> withAll(Iterable<? extends T> items);

    /**
     * @since 10.0.
     */
    default <T> ImmutableBag<T> fromStream(Stream<? extends T> stream)
    {
        return Bags.mutable.<T>fromStream(stream).toImmutable();
    }
}
