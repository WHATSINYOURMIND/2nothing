# Create a new simulator
set ns [new Simulator]

# Create trace files for recording simulation results
set nr [open lsr.tr w]
$ns trace-all $nr
set nf [open lsr.nam w]
$ns namtrace-all $nf

# Procedure to finish simulation and generate output files
proc finish {} {
    global ns nr nf
    $ns flush-trace
    close $nf
    close $nr
    exec nam lsr.nam &
    exit 0
}

# Create nodes in the network
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

# Create duplex links between nodes
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n0 $n2 1Mb 10ms DropTail
$ns duplex-link $n1 $n3 1Mb 10ms DropTail
$ns duplex-link $n2 $n3 1Mb 10ms DropTail

# Create agents for sending traffic
set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1
set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

# Set up routing using Link State Routing protocol
$ns rtproto LS

# Set initial color for nodes
$ns color $n0 Red
$ns color $n1 Green
$ns color $n2 Blue
$ns color $n3 Magenta

# Start sending traffic
$ns at 1.0 "$cbr0 start"
$ns at 2.0 "$cbr1 start"

# Change link status during simulation

$ns rtmodel-at 3.0 down $n0 $n1
$ns rtmodel-at 5.0 up $n0 $n1
$ns rtmodel-at 7.0 down $n2 $n3
$ns rtmodel-at 9.0 up $n2 $n3


# Finish simulation and generate output files
$ns at 10.0 "finish"

# Run the simulation
$ns run
