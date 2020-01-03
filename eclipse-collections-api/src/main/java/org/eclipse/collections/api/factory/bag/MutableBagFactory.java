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

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;

/**
 * A factory which creates instances of type {@link MutableBag}.
 */
public interface MutableBagFactory
{
    /**
     * @since 6.0
     */
    <T> MutableBag<T> empty();

    /**
     * Same as {@link #empty()}.
     */
    default <T> MutableBag<T> of()
    {
        return this.empty();
    }

    /**
     * Same as {@link #empty()}.
     */
    default <T> MutableBag<T> with()
    {
        return this.empty();
    }

    /**
     * Same as {@link #with(Object[])}.
     */
    default <T> MutableBag<T> of(T... elements)
    {
        return this.with(elements);
    }

    default <T> MutableBag<T> ofOccurrences(T element, int occurrence)
    {
        return this.withOccurrences(element, occurrence);
    }

    default <T> MutableBag<T> ofOccurrences(T element1, int occurrence1, T element2, int occurrence2)
    {
        return this.withOccurrences(element1, occurrence1, element2, occurrence2);
    }

    default <T> MutableBag<T> ofOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3)
    {
        return this.withOccurrences(element1, occurrence1, element2, occurrence2, element3, occurrence3);
    }

    default <T> MutableBag<T> ofOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3, T element4, int occurrence4)
    {
        return this.withOccurrences(element1, occurrence1, element2, occurrence2, element3, occurrence3, element4, occurrence4);
    }

    default <T> MutableBag<T> ofOccurrences(ObjectIntPair<T>... elementsWithOccurrences)
    {
        return this.withOccurrences(elementsWithOccurrences);
    }

    <T> MutableBag<T> with(T... elements);

    <T> MutableBag<T> withOccurrences(T element, int occurrence);

    <T> MutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2);

    <T> MutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3);

    <T> MutableBag<T> withOccurrences(T element1, int occurrence1, T element2, int occurrence2, T element3, int occurrence3, T element4, int occurrence4);

    <T> MutableBag<T> withOccurrences(ObjectIntPair<T>... elementsWithOccurrences);

    /**
     * Same as {@link #withAll(Iterable)}.
     */
    default <T> MutableBag<T> ofAll(Iterable<? extends T> items)
    {
        return this.withAll(items);
    }

    <T> MutableBag<T> withAll(Iterable<? extends T> items);

    /**
     * @since 10.0.
     */
    <T> MutableBag<T> fromStream(Stream<? extends T> stream);
}
