package ss.week6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import ss.week6.QuickSort;

public class QuickSortTest {

    @Test
    public void testQsort() throws Exception {
        int[] a1 = {215, 453, 769, 407, 718, 925, 580, 467, 212, 407, 756, 248, 154, 682, 733, 715, 677, 967, 214,
                738, 498, 538, 289, 954, 408, 647, 278, 694, 192, 48, 835, 78, 519, 379, 146, 507, 253, 995, 412, 957,
                241, 556, 144, 343, 496, 897, 952, 361, 610, 318, 112, 5, 526, 464, 144, 330, 893, 99, 272, 872, 994,
                943, 194, 24, 386, 525, 779, 490, 522, 585, 325, 745, 964, 496, 769, 911, 66, 339, 495, 173, 858, 33,
                573, 319, 968, 665, 382, 265, 531, 677, 937, 919, 90, 627, 747, 655, 230, 244, 547, 599, 541, 315, 249,
                303, 207, 286, 448, 804, 474, 225, 542, 180, 639, 946, 983, 149, 229, 795, 153, 725, 934, 611, 147, 535,
                581, 491, 505, 953, 674, 575, 288, 189, 228, 446, 59, 147, 913, 59, 97, 609, 484, 726, 582, 28, 451};
        int[] a2 = {535, 290, 687, 59, 445, 506, 103, 692, 871, 769, 664, 317, 136, 85, 547, 171, 206, 913, 990, 260,
                555, 773, 744, 157, 321, 241, 73, 896, 849, 308, 334, 899, 3, 357, 847, 411, 283, 580, 597, 16, 575, 36,
                947, 622, 142, 365, 602, 64, 888, 888, 737, 605, 506, 447, 381, 446, 436, 370, 685, 662, 169, 874, 16,
                857, 963, 302, 47, 359, 653, 322, 47, 634, 212, 638, 868, 841, 393, 241, 760, 291, 269, 107, 174, 882,
                996, 488, 695, 795, 260, 651, 714, 919, 321, 435, 278, 89, 820, 990, 504, 650, 616, 920, 171, 0, 9, 897,
                7, 552, 248, 100, 749, 621, 969, 265, 665, 882, 102, 958, 938, 930, 589, 547, 234, 544, 429, 621, 994,
                782, 190, 821, 23, 558, 232, 513, 156, 358, 479, 238, 768, 263, 14, 847, 683, 374, 369, 806, 123, 631};
        int[] a3 = {73, 936, 246, 744, 326, 482, 227, 224, 988, 75, 818, 280, 673, 875, 533, 850, 375, 166, 982, 886,
                497, 362, 609, 540, 983, 925, 84, 249, 160, 717, 904, 318, 413, 455, 190, 539, 624, 563, 543, 905, 606,
                574, 571, 922, 471, 99, 550, 97, 388, 893, 289, 849, 618, 88, 514, 721, 837, 860, 222, 514, 126, 892};

        // Change below three lines to test your own multi threaded version
        QuickSort.qsort(a1);
        QuickSort.qsort(a2);
        QuickSort.qsort(a3);

        assertArrayEquals(
                new int[]{5, 24, 28, 33, 48, 59, 59, 66, 78, 90, 97, 99, 112, 144, 144, 146, 147, 147, 149, 153, 154,
                        173, 180, 189, 192, 194, 207, 212, 214, 215, 225, 228, 229, 230, 241, 244, 248, 249, 253, 265,
                        272, 278, 286, 288, 289, 303, 315, 318, 319, 325, 330, 339, 343, 361, 379, 382, 386, 407, 407,
                        408, 412, 446, 448, 451, 453, 464, 467, 474, 484, 490, 491, 495, 496, 496, 498, 505, 507, 519,
                        522, 525, 526, 531, 535, 538, 541, 542, 547, 556, 573, 575, 580, 581, 582, 585, 599, 609, 610,
                        611, 627, 639, 647, 655, 665, 674, 677, 677, 682, 694, 715, 718, 725, 726, 733, 738, 745, 747,
                        756, 769, 769, 779, 795, 804, 835, 858, 872, 893, 897, 911, 913, 919, 925, 934, 937, 943, 946,
                        952, 953, 954, 957, 964, 967, 968, 983, 994, 995},
                a1);
        assertArrayEquals(
                new int[]{0, 3, 7, 9, 14, 16, 16, 23, 36, 47, 47, 59, 64, 73, 85, 89, 100, 102, 103, 107, 123, 136, 142,
                        156, 157, 169, 171, 171, 174, 190, 206, 212, 232, 234, 238, 241, 241, 248, 260, 260, 263, 265,
                        269, 278, 283, 290, 291, 302, 308, 317, 321, 321, 322, 334, 357, 358, 359, 365, 369, 370, 374,
                        381, 393, 411, 429, 435, 436, 445, 446, 447, 479, 488, 504, 506, 506, 513, 535, 544, 547, 547,
                        552, 555, 558, 575, 580, 589, 597, 602, 605, 616, 621, 621, 622, 631, 634, 638, 650, 651, 653,
                        662, 664, 665, 683, 685, 687, 692, 695, 714, 737, 744, 749, 760, 768, 769, 773, 782, 795, 806,
                        820, 821, 841, 847, 847, 849, 857, 868, 871, 874, 882, 882, 888, 888, 896, 897, 899, 913, 919,
                        920, 930, 938, 947, 958, 963, 969, 990, 990, 994, 996},
                a2);
        assertArrayEquals(
                new int[]{73, 75, 84, 88, 97, 99, 126, 160, 166, 190, 222, 224, 227, 246, 249, 280, 289, 318, 326, 362,
                        375, 388, 413, 455, 471, 482, 497, 514, 514, 533, 539, 540, 543, 550, 563, 571, 574, 606, 609,
                        618, 624, 673, 717, 721, 744, 818, 837, 849, 850, 860, 875, 886, 892, 893, 904, 905, 922, 925,
                        936, 982, 983, 988},
                a3);

    }
}
